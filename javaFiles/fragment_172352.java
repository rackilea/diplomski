public void setHour(int num)
{       
    if(num > 23 || num < 0)
        num = _defaultVal;

    _minFromMid = (num*60)+_minFromMid % 60;
}

public void setMinute(int num)
{

    if(num > 59 || num < 0)
        num = _defaultVal;

    _minFromMid = num + (_minFromMid/60)*60;

}