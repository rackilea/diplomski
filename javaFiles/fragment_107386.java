String input = "access_token=CAABletmsJHgBAEMfdJEgA1wEXgqwVgfM1nr" +
    "TgyHq9XxkIEvLVGOUMq80ZBaA2ZA6Ndc18xNwZAJCDwpILNSKgGiVu4SIm9B" +
    "as5ocv7ZCVFV1bxKrNW9qrIqK1HKIz3uD6nO4RQnVgfVmLggoqZCVkPwjEY79" +
    "ijZC0SYKPYM2RN9qg4TZB5E2iMz5WfAAACddAbXaEZCbzkBSoSZBTlEyea8rC" +
    "&expires=5181509";
//                           ┌ preceded by "access_token"
//                           |                 ┌ anything reluctantly quantified 
//                           |                 |  ┌ followed by "&"
Pattern p = Pattern.compile("(?<=access_token=).+?(?=&)");
Matcher m = p.matcher(input);
if (m.find()) {
    System.out.println(m.group());
}