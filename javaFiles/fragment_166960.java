module.exports = function (grunt) {
grunt.initConfig({
    bower: {
        install: {
            options: {
                targetDir: './src',
                cleanBowerDir: true
            }
        }
    },
    exec: {
        buildUI: {
            command: 'chmod 755 ./build.sh && chmod 755 ./build.sh && ./build.sh'
        }
    },
    replace: {
        replaceHtmlCacheTag: {
            src: ['./*.html', './cache.manifest'],
            dist: ['../'], // Minify all js file in dist folder
            replacements: [{
                    from: /\$\{timestamp\}/g,
                    to: "<%= grunt.template.today('ddmmyyyyhMMss') %>"
                }]
        }

    }