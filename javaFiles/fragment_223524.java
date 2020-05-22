else{
                boolean keyFound = false;
                Iterator i = _validationObjects.iterator();
                while(i.hasNext()){
                    ValidationObject obj = (ValidationObject)i.next();
                    if(obj.getKey().equals(key)){
                        obj.addLine(value);
                        keyFound = true;
                    }
                }
                if(!keyFound){
                        ValidationObject vo = new ValidationObject();
                        vo.setKey(key);
                        vo.addLine(value);
                        _validationObjects.add(vo);
                }
            }