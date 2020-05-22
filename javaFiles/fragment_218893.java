class MainWindow : public QMainWindow
{
    (...)
    public slots:
        void applicationStateChanged(Qt::ApplicationState state);
}

void MainWindow::applicationStateChanged(Qt::ApplicationState state)
{
    if(state != Qt::ApplicationActive)
    {
        // Don't update GUI if we're not the active application
        ui->centralWidget->setVisible(false);
        qDebug() << "Hiding GUI because not active state: " << state;
    }
    else
    {
        ui->centralWidget->setVisible(true);
        qDebug() << "Showing GUI because active now.";
    }
}