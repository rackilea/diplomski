try
        {
          SAXParserFactory factory = SAXParserFactory.newInstance();
          SAXParser saxParser = factory.newSAXParser();
          InputStream is = null;

          String xml = "<![CDATA[<translation>"+
          "<clause keyword=\"Alternative\"><en>Alternative</en><alt>Alternative</alt></clause>"+
          "<clause keyword=\"Back\"><en>Back</en><alt>Back</alt></clause>"+
          "<clause keyword=\"BackgroundImage\"><en>Bg. Image</en><alt>Bg. Image</alt></clause>"+
          "<clause keyword=\"ButtonColor\"><en>Button Color</en><alt>Button Color</alt></clause>"+
          "<clause keyword=\"ButtonText\"><en>Button Text</en><alt>Button Text</alt></clause>"+
          "<clause keyword=\"CategoryId\"><en>Category Id</en><alt>Category Id</alt></clause>"+
          "<clause keyword=\"English\"><en>English</en><alt>English</alt></clause>"+
          "<clause keyword=\"GsmNo\"><en>Gsm No</en><alt>Gsm No</alt></clause>"+
          "<clause keyword=\"GsmNumber\"><en>Gsm Number</en><alt>Gsm Number</alt></clause>"+
          "<clause keyword=\"LabelColor\"><en>Label Color</en><alt>Label Color</alt></clause>"+
          "<clause keyword=\"Language\"><en>Language</en><alt>Language</alt></clause>"+
          "<clause keyword=\"LanguageId\"><en>Lang Id</en><alt>Lang Id</alt></clause>"+
          "<clause keyword=\"Password\"><en>Password</en><alt>Password</alt></clause>"+
          "<clause keyword=\"PosSetup\"><en>Pos Setup</en><alt>Pos Setup</alt></clause>"+
         "<clause keyword=\"Redemption\"><en>Redemption</en><alt>Redemption</alt></clause>"+
          "<clause keyword=\"RedemptionSetup\"><en>Redemption Setup</en><alt>Redemption Setup</alt></clause>"+
          "<clause keyword=\"Sale\"><en>Sale</en><alt>Sale</alt></clause>"+
          "<clause keyword=\"Save\"><en>Save</en><alt>Save</alt></clause>"+
          "<clause keyword=\"ServiceUrl\"><en>Service Url</en><alt>Service Url</alt></clause>"+
          "<clause keyword=\"Setup\"><en>Setup</en><alt>Setup</alt></clause>"+
          "<clause keyword=\"Submit\"><en>Submit</en><alt>Submit</alt></clause>"+
          "<clause keyword=\"TerminalId\"><en>Terminal Id</en><alt>Terminal Id</alt></clause>"+
          "<clause keyword=\"TransactionId\"><en>Transaction Id</en><alt>Transaction Id</alt></clause>"+
          "<clause keyword=\"Void\"><en>Void</en><alt>Void</alt></clause>"+
          "<clause keyword=\"Voucher\"><en>Voucher</en><alt>Voucher</alt></clause>"+
          "<clause keyword=\"VoucherId\"><en>Voucher Id</en><alt>Voucher Id</alt></clause>"+
          " </translation>]]>";

          String newXml = xml.substring(xml.indexOf("<translation>"), xml.indexOf("]]"));         
          System.out.println(newXml);
          is = new ByteArrayInputStream(newXml.getBytes());
          InputSource inputSource = new InputSource(is);
          saxParser.parse(inputSource,new xmlHandler());
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }