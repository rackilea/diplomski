private String printPath2()
{
    String result = "";
    if(this == this.previous)
    {
        result = this.name;
    }
    else if(this.previous == null)
    {
        result = this.name + "(unreached)";
    }
    else
    {
        result += this.previous.printPath2();
        result += this.name;
    }
    return result;
}