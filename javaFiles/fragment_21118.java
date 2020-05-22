public static void main(String[] args) {

String result = JOptionPane.showInputDialog("Enter User ID", "");
if(result == null) {
 System.out.println("cancel selected");
return;

}
            int userId = Integer.parseInt(result.trim());
        System.out.println("user id is:" + userId );


}