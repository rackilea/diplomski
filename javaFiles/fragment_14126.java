capabilities: {
    browserName: 'chrome',
    proxy: proxy
    chromeOptions: {
      args: ['--proxy-bypass-list=<-loopback>']
    }
  },