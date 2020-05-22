...

[1/20/15 10:22:14:431 EDT] 00000020 driver        Z   263D263D Enter: 1, "parameter 1", 2
[1/20/15 10:22:14:431 EDT] 00000020 driver        1   263D263D Public Enter: 1, "parameter 1"
[1/20/15 10:22:14:431 EDT] 00000020 driver        2   263D263D Enter: 1, "parameter 1", 2
[1/20/15 10:22:14:431 EDT] 00000020 driver        2   263D263D Enter: 1, "parameter 1", 2, 0
[1/20/15 10:22:14:431 EDT] 00000020 driver        2   263D263D Enter: 1, "parameter 1", 2, 0
[1/20/15 10:22:14:431 EDT] 00000020 driver        2   263D263D Enter: 1, oracle.sql.NUMBER@42764276
[1/20/15 10:22:14:431 EDT] 00000020 driver        <   263D263D Exit [0.0409ms]
[1/20/15 10:22:14:431 EDT] 00000020 driver        <   263D263D Exit [0.1926ms]
[1/20/15 10:22:14:431 EDT] 00000020 driver        <   263D263D Exit [0.2515ms]
[1/20/15 10:22:14:431 EDT] 00000020 driver        <   263D263D Exit [0.3107ms]
[1/20/15 10:22:14:431 EDT] 00000020 driver        1   263D263D Exit [0.4817ms]
[1/20/15 10:22:14:431 EDT] 00000020 driver        Z   263D263D Exit [0.5556ms]
[1/20/15 10:22:14:431 EDT] 00000020 driver        Z   263D263D Enter: 2, "parameter 2"
[1/20/15 10:22:14:431 EDT] 00000020 driver        1   263D263D Public Enter: 2, "parameter 2"
[1/20/15 10:22:14:431 EDT] 00000020 driver        2   263D263D Enter: 2, "parameter 2"
[1/20/15 10:22:14:431 EDT] 00000020 driver        2   263D263D Enter: 2, "parameter 2"
[1/20/15 10:22:14:431 EDT] 00000020 driver        <   263D263D Exit [0.0049ms]
[1/20/15 10:22:14:431 EDT] 00000020 driver        <   263D263D Exit [0.0691ms]
[1/20/15 10:22:14:431 EDT] 00000020 driver        1   263D263D Exit [0.1276ms]
[1/20/15 10:22:14:431 EDT] 00000020 driver        Z   263D263D Exit [0.2008ms]
[1/20/15 10:22:14:431 EDT] 00000020 driver        Z   263D263D Enter: 3, "parameter 3"
[1/20/15 10:22:14:431 EDT] 00000020 driver        1   263D263D Public Enter: 3, "parameter 3"
[1/20/15 10:22:14:431 EDT] 00000020 driver        2   263D263D Enter: 3, "parameter 3"
[1/20/15 10:22:14:431 EDT] 00000020 driver        2   263D263D Enter: 3, "parameter 3"
[1/20/15 10:22:14:431 EDT] 00000020 driver        <   263D263D Exit [0.0036ms]
[1/20/15 10:22:14:431 EDT] 00000020 driver        <   263D263D Exit [0.0549ms]
[1/20/15 10:22:14:431 EDT] 00000020 driver        1   263D263D Exit [0.1094ms]
[1/20/15 10:22:14:431 EDT] 00000020 driver        Z   263D263D Exit [0.161ms]

...

[1/20/15 10:22:14:433 EDT] 00000020 driver        2   32B732B7 Enter: "

{call schema_user.plsql_package.procedure(
param_1 => :param_1,
param_2 => :param_2,
param_3 => :param_3)}"

...

[1/20/15 10:22:14:434 EDT] 00000020 driver        2   32B732B7 Return: 

BEGIN schema_user.plsql_package.procedure(
param_1 => :param_1,
param_2 => :param_2,
param_3 => :param_3); END;

...