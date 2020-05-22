public void setScale(String scale){
        if("C".equalsIgnoreCase(scale) || "celsius".equalsIgnoreCase(scale)) {
            if(!this.scale.equals(scales[0])) {
                convertToCelsius();
                this.scale = scales[0];
             }
        } else {
            System.out.println("Invalid scale");
        }
    }