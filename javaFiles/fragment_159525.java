my $rx2 = qr{
    (?: [+-]                (?{ say "\tleading sign"                })
    ) ?
    (?: \d+                 (?{ say "\tinteger part"                })
        (?: \.              (?{ say "\tinternal decimal point"      })
            \d*             (?{ say "\toptional fractional part"    })
        ) ?
      |
        \.                  (?{ say "\tleading decimal point"       })
        \d+                 (?{ say "\trequired fractional part"    })
    )                       (?{ say "\tsuccess"                     })
}x;