@Override
public int compareTo( OrderPlacement o ) 
{
    int d = -Boolean.compare( order.vip_status, o.order.vip_status );
    if( d != 0 )
        return d;
    return Integer.compare( priority, o.priority );
}