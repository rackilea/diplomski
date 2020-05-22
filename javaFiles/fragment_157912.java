ScriptResult result = page2.executeJavaScript(buttonJavaScript);
            webClient.waitForBackgroundJavaScript(1000);

            if( attachments.size() > 0 )
            {
                Attachment attachment = attachments.get(0);

                Page attachedPage = attachment.getPage();
                WebResponse attachmentResponse = attachedPage.getWebResponse();

                String content = attachmentResponse.getContentAsString();

                ... write(content); 
            }