MyTextHandler handler=new MyTextHandler();
reader.setContentHandler(handler);
InputSource is = new InputSource(filename);
reader.parse(is);

ArrayList<YourModel> list=handler.getList();