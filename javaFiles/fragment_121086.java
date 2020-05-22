Try this
            String sentence  = "Hello friends 123456";
            String[] parts = sentence.split(" ");
            parts[parts.length - 1] = "\n" + parts[parts.length - 1];

            StringBuilder builder = new StringBuilder();
            for (String part : parts) {
                builder.append(part);
                builder.append(" ");
            }

            System.out.println(builder.toString());