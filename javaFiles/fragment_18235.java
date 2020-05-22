QFile stdin = new QFile();
stdin.open(0, new QIODevice.OpenMode(QIODevice.OpenModeFlag.ReadOnly));
QFile stdout = new QFile();
stdout.open(1, new QIODevice.OpenMode(QIODevice.OpenModeFlag.WriteOnly));
QFile stderr = new QFile();
stderr.open(2, new QIODevice.OpenMode(QIODevice.OpenModeFlag.WriteOnly));