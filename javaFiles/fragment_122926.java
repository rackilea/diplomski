public class Story { 

public int delay;
public int x;
public int y;

public String[] text = {"D","i","c","e","r","i","t","a","k","a","n"," ", "a","d","a"," ","s","e","o","r","a", "n", "g",
        " ","p","e","m","u","d","a"," ","b","e","r","n", "a","m","a"," ","b","o","r","a","k", "s", " ","y","a","n","g"," ","m",
        "e","m","i","l","i","k", "i"," ","d","e","n","d","a","m"," ", "t", "e","r","h","a","d","a","p"," ","k","e","m","a","t",
        "i","a","n"," ","a","d","i","k","n", "y", "a", " ", "R","e","m","a","n","."
};

String text2[] = {"R","e","m","a","n"," "," ","t", "e","w","a","s"," ","d",
        "i","t","a", "n", "g","a","n"," ","p","e","n","j","a","h","a","t"," ", "n","o","m","o","r"," ","1"," ","d", "i", " ","d","u","n","i","a"," ",
        "y","a","i","t","u"," ", "B","u","k","a"," ","d","a","d","a", "."
};

String text3[] = {"L","i","n","l","i","n"," ",
        "p","a","c","a","r"," ","b","o", "r","a","k","s"," ","j",
        "u","g","a", " ", "m","e","r","a","s","a","k","a","n", " ", "k","e","p","e", "d","i","h","a","n"," ","p","a","c", "a", "r","n","y","a",","," ","i",
        "a"," ","p","u","n"," ", "m","e","m","u","t","u","s","k","a", "n"," ", "u","n","t","u","k"," ","m","e","m","b","a","n","t","u", " ","b","o","r","a","k","s",".",
};

String text4[] = {"S","i","a","p","k","a","h"," ","a","n","d","a"," ", "m","e","m","b","a","n","t","u"," ", "m", "e","m","b","a","l","a","s","k","a","n"," ", "d","e","n","d","a","m", " i","n","i" ,"?"
};

String text5[] = {"P","e","n","c","e","t"," ","t","o","m","b","o","l", " s","pa","si"," ","un","tu","k ","me","la", "nj", "ut","ka","n..."
};

String story,story2,story3,story4,story5;
public int index,index2,index3,index4,index5;
BufferedImage load;            

public Story(){
    x=180;
    y=0;
    index=0;
    index2=0;
    index3=0;
    index4=0;
    index5=0;
    story="";
    story2="";
    story3="";
    story4="";
    story5="";

    ImageLoader loader = new ImageLoader();
    load = loader.load("/assets/story.jpg");

}

public void render(Graphics g){
    //background
    g.drawImage(load, 0, 0, null);

    g.drawString(story,x,y+100);
    g.drawString(story2,x,y+150);
    g.drawString(story3,x,y+200);
    g.drawString(story4,x,y+250);
    g.drawString(story5,x,y+350);
}


public void tick() {
    delay++;
    if(delay > 2) {
        if(index < text.length) {
            story=story+text[index];
            index++;
        } else if(index2<text2.length){
                story2=story2+text2[index2];
                index2++;
        } else if(index3<text3.length){
                story3=story3+text3[index3];
                index3++;
        } else if(index4<text4.length){
                story4=story4+text4[index4];
                index4++;
        }else if(index5<text5.length){
                story5=story5+text5[index5];
                index5++;
        }

        delay = 0;

    }
}

}