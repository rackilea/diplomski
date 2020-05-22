String test = "front stuff grp2=\"abc\" middle stuff grp4=\"xyz\" end stuff";
Pattern p = Pattern.compile("([\\s\\S]*?)(grp2=\"\\S*?\")(?:([\\s\\S]*?)(grp4=\"\\S*?\")){0,1}([\\s\\S]*)");
Matcher m = p.matcher(test);

for(int i=1; i<=m.groupCount(); i++) {
    if(m.group(i)!=null) {
        System.out.println(i+": "+m.group(i));
    }
}
// String test = "front stuff grp2=\"abc\" middle stuff grp4=\"xyz\" end stuff";
// 1: front stuff 
// 2: grp2="abc"
// 3:  middle stuff 
// 4: grp4="xyz"
// 5:  end stuff

// String test = "front stuff grp2=\"abc\" end stuff";
// 1: front stuff 
// 2: grp2="abc"
// 3:  end stuff