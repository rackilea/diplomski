private BodyPartDOM collectBodyParts(Part part) throws IOException, MessagingException {

        BodyPartDOM dom = new BodyPartDOM();

        Object content = part.getContent();

        if (content instanceof String) {

            // process as string

        } else if (content instanceof Multipart) {


            Multipart innerMultiPart = (Multipart) content;
            int count = innerMultiPart.getCount();

            for (int i = 0; i < count; i++) {

                BodyPart innerBodyPart = innerMultiPart.getBodyPart(i);
                BodyPartDOM subDom = collectBodyParts(innerBodyPart);
                // further recursive processing

            }

        } else if (content instanceof InputStream) {

            // process inputStream

        }

        return dom;

    }