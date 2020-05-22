package com.overflow.stack;

    /**
     *
     * @author sarath_sivan
     */

    public class ExtractHtmlTags {

        public static void getHtmlTags(String html) {
            int beginIndex = 0;
            while(beginIndex!=-1) {
                beginIndex = html.indexOf("<", 0);
                int endIndex = html.indexOf(">", beginIndex+1);
                String htmlTag = "";
                try {
                    if(beginIndex!=-1) {
                        htmlTag = html.substring(beginIndex, endIndex+1);
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }
                System.out.println(htmlTag);
                html = html.substring(endIndex+1, html.length());
            }
        }

        public static void main(String[] args) {
            String html = "<html><body><h2>List HTML tags from a String</h2>hello<br /></body></html>";
            ExtractHtmlTags.getHtmlTags(html);
        }

    }