public static void main(String[] args) {
    String version1 = "1.0.4.1";
    String version2 = "1.0.6.1";

    int result = compare(version1, version2);

    if(result==1){
        System.out.println("Latest version:"+version1);
    }else if(result==-1){
        System.out.println("Latest version:"+version2);
    }else{
        System.out.println("Both version same:"+version2);
    }
}

public static int compare(String version1, String version2){

    String ver1[]=version1.split("\\.");
    String ver2[]=version2.split("\\.");
    int counter =0;
    int len1= ver1.length;
    int len2= ver2.length;

    for(String v:ver1){

        if(len1>0 && len2>0 && v.compareTo(ver2[counter])>0 ){
            return 1;
        }else{
            if(len1>0 && len2>0 && v.compareTo(ver2[counter])<0) {
                return -1;
            }else{
                len1--;
                len2--;
                counter++;
            }   

        }
    }

    if(ver1.length > ver2.length){
        return 1;
    }else
        if(ver1.length < ver2.length){
            return -1;
        }

    return 0;
}