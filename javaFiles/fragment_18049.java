String[] data = rowData.get(rowIndex);
                    StringJoiner joiner = new StringJoiner("<br>", "<html>", "</html>");
                    for (String text : data) {
                        joiner.add(text);
                    }
                    value = joiner.toString();