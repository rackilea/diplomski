public class HtmlParser {

    String url = "http://www.oddsportal.com/soccer/italy/serie-a-2003-2004/results/";
    Document document = Jsoup.connect(url).get();

    Elements stats = document.select("#tournamentTable tbody tr");

    for(int i = 0; i < stats.size(); i++){
        System.out.println(stats.get(i).text());
    }
}

Output:

Soccer» Italy»Serie A 2003/2004

1 X 2 B's


AC Milan - Brescia 4:2 - - - 6

Chievo - Bologna 2:1 - - - 5

Empoli - Inter 2:3 - - - 5

Parma - Udinese 4:3 - - - 5

Lazio - Modena 2:1 - - - 4

Lecce - Reggina 2:1 - - - 5

Perugia - Ancona 1:0 - - - 1

Sampdoria - AS Roma 0:0 - - - 4

Siena - Juventus 1:3 - - - 5

1 X 2 B's



Ancona - Empoli 2:1 - - - 1

AS Roma - Perugia 1:3 - - - 3

Bologna - Lecce 1:1 - - - 7

Brescia - Lazio 2:1 - - - 1

Inter - Parma 1:0 - - - 7

Juventus - Sampdoria 2:0 - - - 7

Modena - Siena 1:3 - - - 7

Reggina - AC Milan 2:1 - - - 1

Udinese - Chievo 1:1 - - - 3

1 X 2 B's



AC Milan - AS Roma 1:0 - - - 6

Parma - Ancona 3:1 - - - 3

Lazio - Reggina 1:1 - - - 6

Lecce - Inter 2:1 - - - 6

Perugia - Juventus 1:0 - - - 4

Sampdoria - Udinese 1:3 - - - 5

Siena - Brescia 0:1 - - - 3

1 X 2 B's



Ancona - Chievo 0:2 - - - 3

AS Roma - Empoli 3:0 - - - 6

Inter - Lazio 0:0 - - - 6

Juventus - Lecce 3:4 - - - 6

Modena - Sampdoria 1:0 - - - 5

Reggina - Parma 1:1 - - - 5

Udinese - AC Milan 0:0 - - - 6

1 X 2 B's



Lazio - AS Roma 1:1 - - - 7

1 X 2 B's



Modena - AS Roma 0:1 - - - 6

Chievo - Reggina 0:0 - - - 4

Empoli - Brescia 1:1 - - - 5

Parma - Juventus 2:2 - - - 6

Inter - Bologna 4:2 - - - 6

Lazio - Ancona 4:2 - - - 5

Sampdoria - Perugia 3:2 - - - 6

1 X 2 B's



Lecce - Udinese 2:1 - - - 6

Siena - AC Milan 1:2 - - - 5

1 X 2 B's



Perugia - Inter 2:3 - - - 7

1 X 2 B's



Juventus - Lazio 1:0 - - - 7

AC Milan - Empoli 1:0 - - - 7

Ancona - Bologna 3:2 - - - 7

AS Roma - Chievo 3:1 - - - 7

Brescia - Modena 0:0 - - - 7

Reggina - Udinese 0:1 - - - 7



Siena - Sampdoria 0:0 - - - 7