@AssertTrue(message="There is a value which is null")
public boolean hasNotNullValues(){
        for (Map.Entry<Long, Boolean> entry : longToBooleanMap.entrySet()) {
           for (Map.Entry<Long, Boolean> entry : longToBooleanMap.entrySet()) {
            if(null == entry.getValue())
                return false
        }
        return true;
        }
   }