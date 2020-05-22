try {
        Class<?> objClass = obj.getClass();
        List<Object> subObjectList = new ArrayList<Object>();
        // Loop over all the fields and add the info for each field
        for (Field field: objClass.getDeclaredFields()) {
            if(!field.isSynthetic()){
                if(isWrapperType(field.getType())){
                    System.out.println("Name: " + field.getName() + " Value: " + field.get(obj));
                }
                else{
                    if(field.getType().isArray()){
                        Object[] fieldArray = (Object[]) field.get(obj);
                        for(int i = 0; i < fieldArray.length; i++){
                            subObjectList.add(fieldArray[i]);
                        }
                    }
                    else{
                        subObjectList.add(field.get(obj));
                    }
                }
            }
        }

        for(Object subObj: subObjectList){
            printObjectFields(subObj);
        }
    }catch(IllegalArgumentException e){
        // TODO Auto-generated catch block
        e.getLocalizedMessage();
    } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.getLocalizedMessage();
    }