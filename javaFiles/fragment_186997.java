const ngConstant = require('gulp-ng-constant');

gulp.task('build', gulp.series('ngconstant:prod', gulp.parallel('other', 'webpack:dist')));

    gulp.task('ngconstant:prod', function () {
      return ngConstant({
          name: 'yourApp',
          constants: {
              BASE_URL : 'http://www.exemple.com:8080'
          },
          template: conf.constantTemplate,
          stream: true
      })
      .pipe(rename('app.constants.js'))
      .pipe(gulp.dest(conf.app + 'app/'));
    });