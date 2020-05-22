GeneralName generalName = new GeneralName(subjectDN);
ProtectedPKIMessageBuilder pbuilder = new 
ProtectedPKIMessageBuilder(generalName,
                    protectedPKIMessage.getHeader().getSender());
            pbuilder.setBody(pkibody);
            ContentSigner msgsigner = new 
            JcaContentSignerBuilder(contentSignerBuilder)//
                   .setProvider("BC")//
                   .build(getKey().getPrivate());

           ProtectedPKIMessage message = pbuilder.build(msgsigner)