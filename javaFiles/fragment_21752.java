module: {
    loaders: [
        {
            test: path.join(__dirname, '.'),
            exclude: /(node_modules)/,
            loader: 'babel-loader',
            query: {
                cacheDirectory: true,
                plugins: ['transform-runtime'],
                presets: ['es2015', 'stage-0', 'react']
            }
        }
    ]
}