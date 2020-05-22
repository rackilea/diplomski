List<String> myList = new ArrayList<String>();

for... (picks up each category)
    for...(picks up items in category)
        for (String propertyName : item.getPropertyNames()) { 
                myList.add(category.getName() + "\t"
                        + itemDesc.getName() + "\tProperty:"
                        + propertyName);    
            }
     }
}

int i = 0;
// Here we assume that the total lines output by the previous set of loops is
// equal to the total output by this loop.
for (Function function : Functions.allFunctions) {
    out.println(myList.get(i) + "\t" + function.getSignature());   
    i++;
}