const QStringList taskList = QString("working|xy|2|3*working1|xy|8|7*working3|xy|12|15*working4|xy|17|20").split('*');

    for (const QString& task : taskList)
    {
        auto params = task.split('|');
        /* Perform 1 task */
       // ...
    }

/* Report back to server */
// ...