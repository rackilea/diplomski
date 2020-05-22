XmlNodeList nodes = doc.SelectNodes("//org.yccheok.jstock.engine.Stock");

foreach (XmlElement element in nodes)
{
    Console.WriteLine("1: {0} 2: {1}", 
        element.SelectSingleNode("code").InnerText,
        element.SelectSingleNode("changePricePercentage").InnerText);
}
Console.ReadKey();