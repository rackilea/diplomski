valueswitch._default()
            .body()
            ._throw(JExpr._new(exception)
                    .arg(
                            JOp.plus(JExpr.lit("Invalid code "), codeParam)
                    ));