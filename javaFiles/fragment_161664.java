StringBuffer sb = new StringBuffer(" ");
    for (Iterator<Element> it = tdElements.iterator(); it.hasNext();) {
                    if (it.hasNext()) {
                        sb.deleteCharAt(sb.length() - 1);
                        sb.append("  \n  ");
                    }
                    for (Iterator<Element> it2 = trElement2.iterator(); it.hasNext();) {
                        Element tdElement = it.next();
                        final String content = tdElement.text();

                        if (it2.hasNext()) {
                            sb.append(formatData(content));
                            sb.append(",");

                        }

                        if (!it2.hasNext()) {
                            String content1 = content.replaceAll(",$", " ");
                            sb.append(formatData(content1));
                            break;
                        } //to remove last placed Commas.

                    }

                    System.out.println(sb.toString());
                    sb.flush();
                    sb.close();


}