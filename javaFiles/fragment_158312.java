k = ingMap.get("A");
if (k != null) {
    if (k.containsKey("Class3")) {            
        k.put("Class3", k.get("Class3")+1);
    }
    else {                        
        k.put("Class3", 1.0);                    
    }
}