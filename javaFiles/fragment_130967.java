public class Q19684865 {

    public static void main(String[] args) {
        String json = " {    "                                                                   
                + "     \"status\":\"200\",                                                  "
                + "     \"results\":{                                                        "
                + "     \"resultitems\":[                                                    "
                + "         {                                                                "
                + "             \"uri\":\"/document/id/e20a8dad50d91a839c50ab5f323f3df3\",   "
                + "             \"path\":\"Data/xyz/abcdata\",                               "
                + "             \"metadata\":{                                               "
                + "                 \"data/category/item\":\"yahoo/post\",                   "
                + "                 \"ast_id\":\"67677\"                                     "
                + "            }                                                             "
                + "     }                                                                    "
                + "    ]                                                                     "
                + "   }                                                                      "
                + " }                                                                        ";

        Container c = new Gson().fromJson(json, Container.class);
        System.out.println("this is the parsed json: " +c);
        System.out.println("this is the property 'data/category/item': "+c.results.resultitems.get(0).metadata.get("data/category/item"));

    }