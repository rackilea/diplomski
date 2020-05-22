String sgml = "<data>\n<subdata>\n<l1item>\n    <note>\n        <para>hello\n        </para>\n    </note>\n</l1item>\n</subdata>\n<subdata>\n<l2item>\n    <para> dont delete \n    </para>\n</l2item>\n<l3item>\n    <note>\n        <para>hello\n        </para>\n    </note>\n    <para> dont delete \n    </para>\n</l3item>\n</subdata>\n</data>";

Document doc = Parser.xmlParser().parseInput(sgml, "");

System.out.println("BEFORE:\n" + doc.html());

Elements onlyChildNotes = doc.select("note:only-child");

for (Element note : onlyChildNotes) {
    Element noteParent = note.parent();
    if (noteParent != null) {
        noteParent.replaceWith(note);
    }
}

System.out.println("AFTER:\n" + doc.html());