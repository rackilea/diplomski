[AttributeUsage(AttributeTargets.Method)]
public class LongArrayHelperAttribute : SoapExtensionAttribute
{
    private int priority = 0;

    public override Type ExtensionType
    {
        get { return typeof (LongArrayHelper); }
    }

    public override int Priority
    {
        get { return priority; }
        set { priority = value; }
    }
}

public class LongArrayHelper : SoapExtension
{
    private static ILog log = LogManager.GetLogger(typeof (LongArrayHelper));

    public override object GetInitializer(LogicalMethodInfo methodInfo, SoapExtensionAttribute attribute)
    {
        return null;
    }

    public override object GetInitializer(Type serviceType)
    {
        return null;
    }

    public override void Initialize(object initializer)
    {
    }

    private Stream originalStream;

    private Stream newStream;

    public override void ProcessMessage(SoapMessage m)
    {
        switch (m.Stage)
        {
            case SoapMessageStage.AfterSerialize:
                newStream.Position = 0; //need to reset stream 
                CopyStream(newStream, originalStream);
                break;

            case SoapMessageStage.BeforeDeserialize:
                XmlWriterSettings settings = new XmlWriterSettings();
                settings.Indent = false;
                settings.NewLineOnAttributes = false;
                settings.NewLineHandling = NewLineHandling.None;
                settings.NewLineChars = "";
                XmlWriter writer = XmlWriter.Create(newStream, settings);

                XmlDocument xmlDocument = new XmlDocument();
                xmlDocument.Load(originalStream);

                List<XmlElement> longArrayItems = new List<XmlElement>();
                Dictionary<string, XmlElement> multiRefs = new Dictionary<string, XmlElement>();
                FindImportantNodes(xmlDocument.DocumentElement, longArrayItems, multiRefs);
                FixLongArrays(longArrayItems, multiRefs);

                xmlDocument.Save(writer);
                newStream.Position = 0;
                break;
        }
    }

    private static void FindImportantNodes(XmlElement element, List<XmlElement> longArrayItems,
                                           Dictionary<string, XmlElement> multiRefs)
    {
        string val = element.GetAttribute("soapenc:arrayType");
        if (val != null && val.Contains(":long["))
        {
            longArrayItems.Add(element);
        }
        if (element.Name == "multiRef")
        {
            multiRefs[element.GetAttribute("id")] = element;
        }
        foreach (XmlNode node in element.ChildNodes)
        {
            XmlElement child = node as XmlElement;
            if (child != null)
            {
                FindImportantNodes(child, longArrayItems, multiRefs);
            }
        }
    }

    private static void FixLongArrays(List<XmlElement> longArrayItems, Dictionary<string, XmlElement> multiRefs)
    {
        foreach (XmlElement element in longArrayItems)
        {
            foreach (XmlNode node in element.ChildNodes)
            {
                XmlElement child = node as XmlElement;
                if (child != null)
                {
                    string href = child.GetAttribute("href");
                    if (href == null || href.Length == 0)
                    {
                        continue;
                    }
                    if (href.StartsWith("#"))
                    {
                        href = href.Remove(0, 1);
                    }
                    XmlElement multiRef = multiRefs[href];
                    if (multiRef == null)
                    {
                        continue;
                    }
                    child.RemoveAttribute("href");
                    child.InnerXml = multiRef.InnerXml;
                    if (log.IsDebugEnabled)
                    {
                        log.Debug("Replaced multiRef id '" + href + "' with value: " + multiRef.InnerXml);
                    }
                }
            }
        }
    }

    public override Stream ChainStream(Stream s)
    {
        originalStream = s;
        newStream = new MemoryStream();
        return newStream;
    }

    private static void CopyStream(Stream from, Stream to)
    {
        TextReader reader = new StreamReader(from);
        TextWriter writer = new StreamWriter(to);
        writer.WriteLine(reader.ReadToEnd());
        writer.Flush();
    }
}