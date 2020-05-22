class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  int page = 0;
  final int maxPages = 3;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Column(
        children: <Widget>[
          if(page == 0)
            Text("This is view 1"),
          if(page == 1)
            Text("This is view 2"),
          if(page == 2)
            Text("This is view 3"),
          RaisedButton(
            child: Text("Continue"),
            onPressed: (){
              if(page < maxPages){
                setState(() {
                 page++; 
                });
              }
            },
          )
        ],
      )
    );
  }
}