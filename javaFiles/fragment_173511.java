public string ConvertColorToJavaString(Color color)
{
    uint value = (color.A << 24) | (color.R << 16) | (color.G << 8) | color.B;
    var javaString = string.Format("0x{0}", value.ToString("X2"))
    return javaString;
}