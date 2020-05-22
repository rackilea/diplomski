Expected: is <
{
    paymentMethod={
        preAuthorizationProfile={
            amount={
                amount=850, 
                monetaryAmount=UNITEDSTATES_DOLLAR
            }, 
            source={
                sourceSystem=ABCD, 
                sourceLocation=EFGH
            }, 
            preAuthorizationId=OL_DF161216J34491
        }
    }
}
> but: was <
{
    paymentMethod={
        preAuthorizationProfile={
            source={
                sourceSystem=ABCD, 
                sourceLocation=EFGH
            }
        }, 
        preAuthorizationId=OL_DF161216J34491, 
        amount={
            amount=850, monetaryAmount=UNITEDSTATES_DOLLAR
        }
    }
}
>