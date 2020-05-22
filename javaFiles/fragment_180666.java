class getXMLResponseAsyncTask extends AsyncTask<String, Void, Boolean>{

        @Override
        protected void onPreExecute(){
         //do something
        }


        @Override
        public Boolean doInBackground(String... urls) {
            URL url;

            try {
                url = new URL(urls[0]);

                URLConnection connection = url.openConnection();

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(connection.getInputStream());


                NodeList nodes = doc.getElementsByTagName("products");
                for (int i = 0; i < nodes.getLength(); i++) {
                    Element element = (Element) nodes.item(i);
                    NodeList barcode = element.getElementsByTagName("barcode");
                    NodeList name = element.getElementsByTagName("name");
                    NodeList itemcode = element.getElementsByTagName("itemcode");



                    Element barcodeval = (Element) barcode.item(0);
                    Element nameval = (Element) name.item(0);
                    Element itemcodeval = (Element) itemcode.item(0);



                    String BARCODE = barcodeval.getTextContent();
                    String NAME  = nameval.getTextContent();
                    String ITEMCODE = itemcodeval.getTextContent();


                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }

            return false;
        }

        public void onPostExecute(Boolean result) {
        //do something
        }
    }