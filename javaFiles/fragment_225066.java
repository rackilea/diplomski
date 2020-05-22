package org.example.test;

import org.apache.cxf.tools.common.ToolException;
import org.apache.cxf.tools.wsdlto.frontend.jaxws.generators.SEIGenerator;

import java.io.Writer;

/**
 * Just a sample custom generator which use custom velocity template to generate SEI
 *
 */
public class CustomSEIGenerator extends SEIGenerator {

    @Override
    protected void doWrite(String templateName, Writer outputs) throws ToolException {

        if (templateName.endsWith("/sei.vm")) {
            templateName = "valid-sei.vm";
        }

        super.doWrite(templateName, outputs);
    }
}