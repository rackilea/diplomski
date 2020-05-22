Trie tr = new Trie();
tr.Insert("telephone");
while (true)
{
     string str = Console.ReadLine();
     if( tr.Contains( str ) )
         Console.WriteLine("contains!");
     else
         Console.WriteLine("does not contain!");
}