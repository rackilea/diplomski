public static void Generate(string wsdlPath, string outputFilePath) 
    { 
        if (File.Exists(wsdlPath) == false) 
        { 
            return; 
        } 

        ServiceDescription wsdlDescription = ServiceDescription.Read(wsdlPath); 
        ServiceDescriptionImporter wsdlImporter = new ServiceDescriptionImporter(); 

        wsdlImporter.ProtocolName = "Soap12"; 
        wsdlImporter.AddServiceDescription(wsdlDescription, null, null); 
        wsdlImporter.Style = ServiceDescriptionImportStyle.Server; 

        wsdlImporter.CodeGenerationOptions = CodeGenerationOptions.GenerateProperties; 

        CodeNamespace codeNamespace = new CodeNamespace(); 
        CodeCompileUnit codeUnit = new CodeCompileUnit(); 
        codeUnit.Namespaces.Add(codeNamespace); 

        ServiceDescriptionImportWarnings importWarning = wsdlImporter.Import(codeNamespace, codeUnit); 

        if (importWarning == 0) 
        { 
            StringBuilder stringBuilder = new StringBuilder(); 
            StringWriter stringWriter = new StringWriter(stringBuilder); 

            CodeDomProvider codeProvider = CodeDomProvider.CreateProvider("CSharp"); 
            codeProvider.GenerateCodeFromCompileUnit(codeUnit, stringWriter, new CodeGeneratorOptions()); 

            stringWriter.Close(); 

            File.WriteAllText(outputFilePath, stringBuilder.ToString(), Encoding.UTF8); 
        } 
        else 
        { 
            Console.WriteLine(importWarning); 
        } 
    }