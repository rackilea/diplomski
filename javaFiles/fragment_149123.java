package com.function;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

public class Function {

    @FunctionName("BlobTrigger")
    public void run(
            @BlobTrigger(name = "trigger", path = "test/{fileName}", dataType = "binary", connection = "AzureWebJobsStorage") byte[] content,
            @BindingName("fileName") String fileName,
            final ExecutionContext context) {
                context.getLogger().info("Blob: " + fileName + " -> Length: " + content.length);
    }
}