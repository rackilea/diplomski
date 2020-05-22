String paragraph = "bv xfeu xeelppuq vx t eupvtbf obfc, vktv bi ku twztds ofuz vku pbckv vbnu vx hucbf uaupdvkbfc; bi ku ofuz zkx zupu vku pbckv juxjwu vx wbsvuf vx, tfq zkxn vx taxbq; tfq, thxau tww, bi ku twztds ofuz zktv zts vku nxsv bnjxpvtfv vkbfc vx qx, ku zxlwq fuaup itbw bf tfdvkbfc ku nbckv lfqupvtou.";

String s1 = "etaonrishdlfcmugypwbvkjxqz";
String s2 = "uvxftkbsqpznlcwdeijhoamgyr";
for (int x = 0; x < 26; x++) {
    paragraph = paragraph.replace(s1.charAt(x), s2.charAt(x));
}
System.out.println(paragraph);