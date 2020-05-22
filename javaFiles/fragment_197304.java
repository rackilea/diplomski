$ java -XX:+PrintFlagsFinal -version | grep Inline
     bool C1ProfileInlinedCalls                     = true                                {C1 product}
     intx FreqInlineSize                            = 325                                 {pd product}
     bool IncrementalInline                         = true                                {C2 product}
     bool Inline                                    = true                                {product}
    ccstr InlineDataFile                            =                                     {product}
     intx InlineSmallCode                           = 2000                                {pd product}
     bool InlineSynchronizedMethods                 = true                                {C1 product}
     intx MaxInlineLevel                            = 9                                   {product}
     intx MaxInlineSize                             = 35                                  {product}
     intx MaxRecursiveInlineLevel                   = 1                                   {product}
     intx Tier23InlineeNotifyFreqLog                = 20                                  {product}
     bool UseInlineCaches                           = true                                {product}
     bool UseOnlyInlinedBimorphic                   = true                                {C2 product}