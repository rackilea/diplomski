QStringList wordList;
wordList << "alpha and beta" << "omega" << "omicron" << "zeta";

QCompleter *completer = new QCompleter(wordList, this);
completer->setCaseSensitivity(Qt::CaseInsensitive);

QLineEdit *lineEdit = new QLineEdit(this);
lineEdit->setCompleter(completer);