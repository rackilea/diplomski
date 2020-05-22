bool Application::notify(QObject * receiver, QEvent * event) 
{
    if ( event && 
         event->type() == QEvent::Paint )
    {
        if ( applicationState() != Qt::ApplicationActive )
        {
            return false;
        }
    }
    return QApplication::notify(receiver,event);
}