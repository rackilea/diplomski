static String align(String str, int width, boolean right){
    String[] temp = str.split("\n");
    String frmt = "";
    if(right){
        frmt = "%" + width + "s";
    }
    else{
        frmt = "%-" + width + "s";
    }

    for(int i=0; i<temp.length; i++)
        temp[i] = String.format(frmt, temp[i]);
    return String.join("\n", temp);
}

public static void main(String[] args) {
    String newString = "\nالفرع: الفرع الرئيسي\n" +
                "***********************************\n" +
                "التاريخ والوقت: 2019/01/0218:01\n" +
                "نوع الحركة: مبيعات مضخات  \n" +
                "رقم الفاتورة: 14\n" +
                "طريقة الدفع: نقد  \n" +
                "المضخة: م 1 ك 1\n" +
                "\n" +
                "\n" +
                "نوع الوقود: بنزين 95\n" +
                "الكمية: 2.830\n" +
                "السعر: 1.060\n" +
                "الإجمالي: 3.000\n" +
                "\n" +
                "***********************************\n" +
                "          شكرا لزيارتكم\n" +
                " \n" +
                " ";
    System.out.println(align(newString, 35, false));

}