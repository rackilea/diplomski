public static void parsingHTML() throws Exception {
        File fold = new File("C:\\open-end-smry.csv");
        fold.delete();
        for (Element table : doc.getElementsByTag("table")) {

            for (Element trElement : table.getElementsByTag("tr")) {
                trElement2 = trElement.getElementsByTag("tr");
                tdElements = trElement.getElementsByTag("td");
                File fnew = new File("C:\\open-end-smry.csv");
                FileWriter sb = new FileWriter(fnew, true);
                if (trElement.hasClass("tab-data1")) {
                    for (Iterator<Element> it = tdElements.iterator(); it.hasNext();) {
                        if (it.hasNext()) {
                            sb.append("\r\n");

                        }

                        for (Iterator<Element> it2 = trElement2.iterator(); it.hasNext();) {
                            Element tdElement2 = it.next();
                            final String content = tdElement2.text();
                            if (it2.hasNext()) {

                                sb.append(formatData(content));
                                sb.append("   ,   ");

                            }
                            if (!it.hasNext()) {
                                String content1 = content.replaceAll(",$", " ");
                                sb.append(formatData(content1));
                                //it2.next();

                            }
                        }

                        System.out.println(sb.toString());
                        sb.flush();
                        sb.close();
                    }
                }
                System.out.println(sampleList.add(tdElements));

            }
        }
    }