HashMap<String, Object> map = new LinkedHashMap<>();

           PropertyIterator pi;
            try {
                pi = node.getProperties();
                //Get properties for the root node
                while(pi.hasNext())
                    {
                       Property p = pi.nextProperty();
                       String name = p.getName();
                       String val;
                       //determine if property is multi-value
                       if (p.isMultiple()) {
                            //multi-value property           
                            val=p.getValues().toString();

                        } else {
                            //single-value property
                            val = p.getValue().getString();

                        }
                        map.put(name,val);

                    }//end of while for properties of root node
            } catch (RepositoryException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }