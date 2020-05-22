StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                        stringBuilder.append(line).append("\n");
                    }
                    text = stringBuilder.toString();