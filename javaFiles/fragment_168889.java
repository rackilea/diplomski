public JsArray<?> push( String[] labels, double[] y )
{
    JsArray<JsArrayMixed> Data = JavaScriptObject.createArray().cast();
    for ( int i = 0; i < y.length; i++ )
    {
        JsArrayMixed series = JavaScriptObject.createArray().cast();
        series.push( dateLabels[i] );
        series.push( y[i] );
        Data.push( series );`enter code here`
    }
    return Data;
}